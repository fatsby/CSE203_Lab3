    package org.example;

    import java.io.IOException;
    import java.util.*;

    public class Store {
        private static Scanner sc = new Scanner(System.in);
        private ArrayList<CD> cdlist = new ArrayList<CD>();
        public Store() {
        }
        public Store(ArrayList<CD> cdlist) {
            this.cdlist = cdlist;
        }

        public void addCD(){
            System.out.println("How many CDs do you want to add?");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                CD cd = new CD();
                cd.addInfo();
                cdlist.add(cd);
            }
        }
        public void findTitle(String title){
            Comparator<CD> compareTitle = new Comparator<CD>() {
                @Override
                public int compare(CD cd1, CD cd2) {
                    return cd1.getTitle().compareTo(cd2.getTitle());
                }
            };

            // Ensure the list is sorted by title before performing binary search
            Collections.sort(cdlist, compareTitle);

            int low = 0;
            int high = cdlist.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int result = title.compareTo(cdlist.get(mid).getTitle());

                if (result == 0) {
                    cdlist.get(mid).getInfo();  // Found the CD, display its info
                    return;
                }

                if (result > 0) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }

            System.out.println("Could not find: " + title);
        }
        public void findCollection(String collection){
            boolean found = false;
            for (CD cd : cdlist) {
                if (cd.getCollection().equals(collection)) {
                    cd.getInfo();
                    found = true;
                }
            }
            if (!found){
                System.out.println("Could not find: " + collection);
            }
        }
        public void findType(String type){
            boolean found = false;
            for (CD cd : cdlist) {
                if (cd.getType().equals(type)) {
                    cd.getInfo();
                    found = true;
                }
            }
            if (!found){
                System.out.println("Could not find: " + type);}
        }
        public void deleteByID(String id){
            Iterator<CD> iterator = cdlist.iterator();
            while (iterator.hasNext()) {
                CD cd = iterator.next();
                if (cd.getId().equals(id)) {
                    iterator.remove();
                    break;
                }
            }
        }
        public void editCD(String id){
            for (CD cd : cdlist) {
                if (cd.getId().equals(id)) {
                    cd.editCD();
                    break;
                }
            }
        }
        public void displayAll(){
            for (CD cd : cdlist) {
                cd.getInfo();
            }
        }
        public void sortYearAscending(){
            cdlist.sort(new Comparator<CD>() {
                @Override
                public int compare(CD o1, CD o2) {
                    return Integer.compare(o1.getReleaseYear(), o2.getReleaseYear());
                }
            });
        }
    }
