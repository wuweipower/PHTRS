package edu.scut.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer damage_id;


    @OneToOne(
            optional = true,//可以为空
            fetch = FetchType.LAZY,//加载一个实体，不会立即从数据库中加载
            targetEntity = Report.class,//关联的目标实体类
            cascade = CascadeType.ALL//级联操作
    )
    @JoinColumn(
            name="report_id",//在数据库中要写这个外键在这个可以不写
            referencedColumnName = "report_id",
            nullable = true
    )
    private Report report;

    private String type;//type of damage

    private Integer dollar;//损失金额
}
