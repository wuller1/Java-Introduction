import java.util.*;

class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.runUI();
    }
}

class UI {
    private HashSet<Notebook> notebooks = new HashSet<>();
    private Set<String> operatingSystems = new HashSet<>();
    private Set<Integer> ramSize = new HashSet<>();
    private Set<Integer> hddSize = new HashSet<>();
    private Set<String> colors = new HashSet<>();

    public void runUI() {
        Scanner scanner = new Scanner(System.in);
        HashSet<Notebook> filteredNotebooks = new HashSet<>();
        setInitialData();
        setFilteringOptions();
        System.out.println("Hello!");

        notebooks.forEach((notebook -> {
            filteredNotebooks.add(notebook);
        }));

        while(true) {
           HashMap<String, String> filteringOptions = new HashMap<>();

            System.out.print("""
                    Enter filtering option:
                    ram - to filter by minimum RAM amount
                    os - to filter by preinstalled operating system
                    hdd - to filter minimum disk storage
                    color - to filter by color
                    show filtered - to show filtered notebooks
                    show all - to show all available notebooks
                    clear - to clear all filtering options
                    exit - to close the program
                    >\s\s""");
            String filteringOption = scanner.nextLine();

            switch (filteringOption) {
                case "exit" -> {return;}
                case "show all" -> printNotebooks(notebooks);
                case "show filtered" -> printNotebooks(filteredNotebooks);
                case "ram" -> filteringOptions.put("ram", getFilteringValue("ram"));
                case "os" -> filteringOptions.put("os", getFilteringValue("os"));
                case "hdd" -> filteringOptions.put("hdd", getFilteringValue("hdd"));
                case "color" -> filteringOptions.put("color", getFilteringValue("color"));
                case "clear" -> {
                    notebooks.forEach((notebook -> {
                        filteredNotebooks.add(notebook);
                    }));
                }
            }
            filterNotebooks(filteringOptions, filteredNotebooks);
        }
    }

    public String getFilteringValue(String filteringOption) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("Enter filtering value, available variants: \n");
        Set<String> availableVariants = getAvailableVariants(filteringOption);
        availableVariants.forEach((variant) -> {
            builder.append("- ").append(variant).append("\n");
        });

        builder.append(">  ");

        System.out.println(builder);
        return scanner.nextLine();
    }

    public void printNotebooks(Set<Notebook> notebooks) {
        StringBuilder builder = new StringBuilder();

        if (notebooks.size() < 1) {
            System.out.println("Nothing found");
        } else {
            notebooks.forEach((notebook) -> {
                builder.append("-".repeat(20)).append("\n")
                        .append("Operating system: ").append(notebook.getOs()).append("\n")
                        .append("HDD/SSD size: ").append(notebook.getHddSize()).append(" GB").append("\n")
                        .append("RAM size: ").append(notebook.getRamSize()).append(" GB").append("\n")
                        .append("Color: ").append(notebook.getColor()).append("\n")
                        .append("-".repeat(20)).append("\n");
            });
        }

        System.out.println(builder);
    }

    public void setInitialData() {
        notebooks.add(new Notebook(16, 500, "Fedora Linux", "black"));
        notebooks.add(new Notebook(8, 1000, "MacOS Ventura", "rose gold"));
        notebooks.add(new Notebook(4, 240, "Windows 11", "white"));
        notebooks.add(new Notebook(32, 2000, "Windows 11", "green"));
        notebooks.add(new Notebook(64, 4000, "Astra Linux", "black"));
    }

    public void filterNotebooks(HashMap<String, String> filteringOptions, HashSet<Notebook> filteredNotebooks) {

        Iterator<Notebook> notebookIterator = filteredNotebooks.iterator();

        while(notebookIterator.hasNext()) {
            Notebook notebook = notebookIterator.next();

            if (filteringOptions.containsKey("color")) {
                if (!notebook.getColor().equalsIgnoreCase(filteringOptions.get("color"))) {
                    notebookIterator.remove();
                }
            } else if (filteringOptions.containsKey("ram")) {
                if (notebook.getRamSize() < Integer.parseInt(filteringOptions.get("ram"))) {
                    notebookIterator.remove();
                }
            } else if (filteringOptions.containsKey("hdd")) {
                if (notebook.getHddSize() < Integer.parseInt(filteringOptions.get("hdd"))) {
                    notebookIterator.remove();
                }
            } else if (filteringOptions.containsKey("os")) {
                if (!notebook.getOs().equalsIgnoreCase(filteringOptions.get("os"))) {
                    notebookIterator.remove();
                }
            }
        }
    }

    public void setFilteringOptions() {
        notebooks.forEach(notebook -> {
            operatingSystems.add(notebook.getOs());
            ramSize.add(notebook.getRamSize());
            hddSize.add(notebook.getHddSize());
            colors.add(notebook.getColor());
        });
    }

    public Set<String> getAvailableVariants(String option) {
        Set<String> filteringVariants = new HashSet<>();

        switch (option) {
            case "os" -> {
                notebooks.forEach((notebook -> {
                    filteringVariants.add(notebook.getOs());
                }));
            }
            case "ram" -> {
                notebooks.forEach((notebook) -> {
                    filteringVariants.add(String.valueOf(notebook.getRamSize()));
                });
            }
            case "hdd" -> {
                notebooks.forEach((notebook) -> {
                    filteringVariants.add(String.valueOf(notebook.getHddSize()));
                });
            }
            case "color" -> {
                notebooks.forEach((notebook) -> {
                    filteringVariants.add(notebook.getColor());
                });
            }
        }
        return filteringVariants;
    }
}