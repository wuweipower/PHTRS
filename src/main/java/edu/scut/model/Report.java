package edu.scut.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer report_id;

    @OneToOne(
            mappedBy = "report",
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
            mappedBy = "report",
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer size;//大小 1-10

    private String district;//根据街道地址确定

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer priority;//优先级，越小越高 根据洞的大小

    private String phone;//报告人的电话，后面的damage要用

    private String address;//报告的人的地址

    public Report( String street, String location, Integer size, String district, Integer priority, String phone, String address) {
        this.street = street;
        this.location = location;
        this.size = size;
        this.district = district;
        this.priority = priority;
        this.phone = phone;
        this.address = address;
    }
}
