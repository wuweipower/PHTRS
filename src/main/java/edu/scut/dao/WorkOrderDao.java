package edu.scut.dao;

import edu.scut.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderDao extends JpaRepository<WorkOrder,Integer> {

}
