package edu.scut.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;

    //对应的报告的id
    //private Integer report_id;
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



    private Integer crew_id;

    private Integer num_of_people;

    private String equipments;

    private Integer hours;

    private Integer hole_status;//work in progress, repaired, temporary repair, not repaired

    private Integer filler_material;//amount of filler material used

    private Integer cost_of_repair;//computed from hours applied, number of people, material and equipment used


}
