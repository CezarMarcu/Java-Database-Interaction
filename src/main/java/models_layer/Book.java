package models_layer;

public class Book {

    private final String title;
    private final String author;
    private final String edit;
    private final String language;
    private final String pages;
    private final String paperback;
    private final String publicationYear;
    private final String dimensions;
    private Long id;
    private String IBSN;


    public Book(String _title, String _author, String _edit, String _language, String _pages, String _paperback, String _publicationYear, String _dimensions) {
        this.title = _title;
        this.author = _author;
        this.edit = _edit;
        this.language = _language;
        this.pages = _pages;
        this.paperback = _paperback;
        this.publicationYear = _publicationYear;
        this.dimensions = _dimensions;
        generateIBSN();
    }

    public Book(Long id, String _title, String _author, String _edit, String _language, String _pages, String _paperback, String _publicationYear,String IBSN, String _dimensions) {
        this.id = id;
        this.title = _title;
        this.author = _author;
        this.edit = _edit;
        this.language = _language;
        this.pages = _pages;
        this.paperback = _paperback;
        this.publicationYear = _publicationYear;
        this.IBSN = IBSN;
        this.dimensions = _dimensions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEdit() {
        return edit;
    }

    public String getLanguage() {
        return language;
    }

    public String getPages() {
        return pages;
    }

    public String getPaperback() {
        return paperback;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getIBSN() {
        return IBSN;
    }

    public String getDimensions() {
        return dimensions;
    }

    private void generateIBSN() {
        String numericString = "0123456789";
        int n = 10;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (numericString.length() * Math.random());
            sb.append(numericString.charAt(index));
        }
        this.IBSN = sb.toString();
    }

    @Override
    public String toString() {
        return "Book{" + "Id:" + id +
                ", Title:'" + title +
                ", author:'" + author +
                ", Edit:'" + edit  +
                ", Language:'" + language +
                ", Pages:'" + pages +
                ", Paperback:'" + paperback +
                ", PublicationYear:'" + publicationYear +
                ", IBSN:'" + IBSN +
                ", Dimensions:'" + dimensions + '}';
    }

}

