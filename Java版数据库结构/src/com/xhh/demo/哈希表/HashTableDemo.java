package com.xhh.demo.哈希表;

/**
 * 哈希表的实现: 数组+链表的存储结构, key-value形式存储数据
 * 为什么使用哈希表(散列表): 为了极大方便查找效率提高
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        Product product1 = new Product(1,"XHH1");
        Product product2 = new Product(2,"XHH2");
        Product product3 = new Product(3,"XHH3");
        Product product4 = new Product(4,"XHH4");
        Product product5 = new Product(5,"XHH5");
        Product product6 = new Product(10,"XHH5");
        hashTable.add(product1);
        hashTable.add(product2);
        hashTable.add(product3);
        hashTable.add(product4);
        hashTable.add(product5);
        hashTable.add(product6);
        System.out.println("查找到的元素值: " + hashTable.findInfoById(1));
        hashTable.show();
    }
}

//哈希表(散列表) 用来管理商品链表类的
class HashTable{
    //创建一个数组
    public ProductLiked[] productLiked;
    //最大容量
    public int maxSize;
    //初始化哈希表
    public HashTable(int maxSize){
        this.maxSize = maxSize;
        this.productLiked = new ProductLiked[maxSize];
        for (int i = 0; i < maxSize; i++){
            productLiked[i] = new ProductLiked();
        }
    }
    //添加商品信息
    public void add(Product product){
        //判断商品是否为null
        if (product == null){
            throw new RuntimeException("不可以传递为空的元素");
        }
        //取余, 决定插入的位置
        int mod = product.id % maxSize;
        //将元素添加进去
        productLiked[mod].addProduct(product);
    }
    //遍历商品信息
    public void show(){
        //循环遍历
        for (int i = 0; i < maxSize; i++){
            System.out.print("第"+ i + "趟 = ");
            productLiked[i].showProduct();
        }
    }
    //根据id查找商品信息
    public Product findInfoById(int id){
        //取模运算, 在该链表中寻找元素
        int mod = id%maxSize;
        return productLiked[mod].findProductById(id);
    }
}

//商品链表类 管理商品类
class ProductLiked{
    //创建一个指向一个元素的指针,不是头节点
    public Product head;
    //初始化信息
    public ProductLiked(){}
    //往哈希表里面添加商品
    public void addProduct(Product product){
        //如果第一个元素的数据域为null, 则添加到这里
        if (head == null){
            head = product;
            return;
        }
        //如果head不为null, 则表示已经存在元素
        Product cur = head;
        //防止哈希冲突
        while (true){
            //循环结束条件: cur指向null
            if (cur.next ==  null){
                break;
            }
            //促使循环进行下一步操作
            cur = cur.next;
        }
        //将商品添加进来
        cur.next = product;
    }
    //根据id查找商品信息
    public Product findProductById(int id){
        //该链表为null的时候,返回null值
        if (head == null){
            return null;
        }
        //设置辅助指针
        Product cur = head;
        while (true){
            if (cur.id == id){
                return cur;
            }
            if (cur.next == null){
                return null;
            }
            //促进循环
            cur = cur.next;
        }
    }

    //遍历商品信息
    public void showProduct(){
        //判断该链表是否为null
        if (head == null){
            System.out.println("该链表没有元素...");
            return;
        }
        //设置辅助指针
        Product cur = head;
        //遍历链表里面的元素
        while (true){
            System.out.println("id="+cur.id + ", name=" + cur.productName);
            //循环结束的条件 cur.next == null
            if (cur.next == null){
                break;
            }
            //使得循环继续
            cur = cur.next;
        }
    }
}

//商品类
class Product{
    //商品id
    public int id;
    //商品名称
    public String productName;
    //指针域
    public Product next;
    //初始化商品信息
    public Product(int id, String productName){
        this.id = id;
        this.productName = productName;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", next=" + next +
                '}';
    }
}

