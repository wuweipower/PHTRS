package edu.scut.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer report_id;

    @OneToOne(
            optional = true,
            fetch = FetchType.LAZY,
            targetEntity = WorkOrder.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="report_id",
            referencedColumnName = "report_id",
            nullable = true
    )
    private WorkOrder workOrder;

    @OneToOne(
            optional = true,
            fetch = FetchType.LAZY,
            targetEntity = Damage.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="report_id",
            referencedColumnName = "report_id",
            nullable = true
    )
    private Damage damage;

    private String street;

    private String location;//在那个位置 中间还是路边上

    private Integer size;//大小 1-10

    private String district;//根据街道地址确定

    private Integer priority;//优先级，越小越高 根据洞的大小

    private String phone;//报告人的电话，后面的damage要用

    private String address;//报告的人的地址


}
