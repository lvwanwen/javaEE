package bookmanager.book;

public class Book {
    private String name;//书名
    private String id;//编号
    private String author;//作者
    private int price;//价格
    private String type;//类型
    private boolean isBorrowed;//是否被借,借出去为true

    public Book(String name, String id, String author,
                int price, String type, boolean isBorrowed) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
