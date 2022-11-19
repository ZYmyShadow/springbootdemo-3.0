package com.hzhazha.springbootdemo.bean;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @Entity注解表示该类是一个实体类，在项目启动时会根据该类自动生成一张表，表的名称即@Entity注解中name的值，如果不配置name，默认表名为类名
 * 所有的实体类都要有主键，@Id注解表示该属性是一个主键，@GneeratedValue注解表示主键自动生成，strategy则表示主键的生成策略
 * 默认情况下，生成的表中字段的名称时实体类中属性的名称，通过@Column注解可以定制生成的字段的属性，name表示该属性对应的数据表中字段的名称，nullable表示该字段非空
 * @Transient注解表示在生成数据库的表时，该属性被忽略，即不生成对应的字段
 * JPA自带的几种主键生成策略：
 * TABLE：使用一个特定的数据库表格来保存主键
 * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要于generator一起使用，generator指定生成主键的生成器
 * IDENTITY：主键由数据库自动生成（主要支持自动增长的数据库，如mysql）
 * AUTO：主键由程序控制，也是GenerationType的默认值
 */

/**
 * @column 的注释有很多种属性。下面是一个完整的列表
 * <p>
 *     type (可选的，默认为 “string”)    映射的 column 类型。
 *     name (可选的，默认为字段名)      映射的 column 名称。
 *     length (可选，默认 255)            映射的 column 长度，只适用于字符串。
 *     unique (可选，默认 false) 表示是否是一个 unique 键。
 *     nullable (可选，默认 false) 表示 column 是否可以为空。
 *     precision (可选，默认 0) 的精度小数 (具体数字) 列 (只适用于十进制列), 这是最大数量的数字存储值。
 *     scale (可选，默认 0) 小数 (确切的规模 为十进制数值) 列 (只适用于列), 代表 数字的位数小数点右边的和必须的 不大于 precision 。
 *     columnDefinition (可选): 允许定义一个自定义的 DDL 片段用于创建列。 警告：这通常 混淆 SchemaTool 总是检测列变化。
 *     options (可选): 键值对的选项获得通过 当生成 DDL 语句到底层数据库平台。
 *
 * Column /  type  的多种类型列表。
 *
 *     string : varchar
 *     integer : int
 *     long : bigint
 *     time : time
 *     timestamp : timestamp
 *     float : float
 *     double : double
 *     bigDecimal : decimal
 *     data : data
 *     bool : bool, boolean
 */

@Entity(name = "test")
public class TestBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键 自增
    @Column
    private String name; // 姓名
    @Column
    private Integer age; // 年龄
    @Column
    private String idCard; // 身份证

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestBean testBean = (TestBean) o;
        return Objects.equals(id, testBean.id) && Objects.equals(name, testBean.name) && Objects.equals(age, testBean.age) && Objects.equals(idCard, testBean.idCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, idCard);
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
