package edu.scut.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer order_id;

    //对应的报告的id
    //private Integer report_id;
    @OneToOne(
           // mappedBy = "workOrder",
            optional = false,//可以为空
            fetch = FetchType.LAZY,//加载一个实体，不会立即从数据库中加载
            targetEntity = Report.class,//关联的目标实体类
            cascade = CascadeType.ALL//级联操作
    )
    @JoinColumn(
            name="report_id",//在数据库中要写这个外键在这个可以不写
            referencedColumnName = "report_id",
            nullable = true,
            insertable = false, updatable = false
    )
    @JsonIgnore
    private Report report;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer report_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer crew_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer num_of_people;

    private String equipments;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer hours;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer hole_status;//work in progress, repaired, temporary repair, not repaired

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer filler_material;//amount of filler material used

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer cost_of_repair;//computed from hours applied, number of people, material and equipment used

    public WorkOrder(Integer report_id, Integer crew_id, Integer num_of_people, String equipments, Integer hours, Integer hole_status, Integer filler_material, Integer cost_of_repair) {
        this.report_id = report_id;
        this.crew_id = crew_id;
        this.num_of_people = num_of_people;
        this.equipments = equipments;
        this.hours = hours;
        this.hole_status = hole_status;
        this.filler_material = filler_material;
        this.cost_of_repair = cost_of_repair;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "order_id=" + order_id +
                ", report_id=" + report_id +
                ", crew_id=" + crew_id +
                ", num_of_people=" + num_of_people +
                ", equipments='" + equipments + '\'' +
                ", hours=" + hours +
                ", hole_status=" + hole_status +
                ", filler_material=" + filler_material +
                ", cost_of_repair=" + cost_of_repair +
                '}';
    }
}
