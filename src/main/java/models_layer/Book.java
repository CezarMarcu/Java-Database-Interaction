package models_layer;

public class Book {

    private Long _id;
    private final String _title;
    private final String _author;
    private final String _edit;
    private final String _language;
    private final String _pages;
    private final String _paperback;
    private final String _publicationYear;
    private String _IBSN;
    private final String _dimensions;


    public Book(String _title, String _author, String _edit, String _language, String _pages, String _paperback, String _publicationYear, String _dimensions) {
        this._title = _title;
        this._author = _author;
        this._edit = _edit;
        this._language = _language;
        this._pages = _pages;
        this._paperback = _paperback;
        this._publicationYear = _publicationYear;
        this._dimensions = _dimensions;
        GenerateIBSN();
    }


    public void set_id(Long _id) {
        this._id = _id;
    }
    public String get_title() {
        return _title;
    }
    public String get_author() {
        return _author;
    }
    public String get_edit() {
        return _edit;
    }
    public String get_language() {
        return _language;
    }
    public String get_pages() {
        return _pages;
    }
    public String get_paperback() {
        return _paperback;
    }
    public String get_publicationYear() {
        return _publicationYear;
    }
    public String get_IBSN() {
        return _IBSN;
    }
    public String get_dimensions() {
        return _dimensions;
    }
    private void GenerateIBSN(){
        String numericString = "0123456789";
        int n = 10;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(numericString.length() * Math.random());
            sb.append(numericString.charAt(index));
        }
        this._IBSN = sb.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "_id=" + _id + "\n" +
                ", _title='" + _title + "\n" +
                ", _author='" + _author + "\n" +
                ", _edit='" + _edit + "\n" +
                ", _language='" + _language + "\n" +
                ", _pages='" + _pages + "\n" +
                ", _paperback='" + _paperback + "\n" +
                ", _publicationYear='" + _publicationYear + "\n" +
                ", _IBSN='" + _IBSN + "\n" +
                ", _dimensions='" + _dimensions + "\n" +
                '}';
    }

}

