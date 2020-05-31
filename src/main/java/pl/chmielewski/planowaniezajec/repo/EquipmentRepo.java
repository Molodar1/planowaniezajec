package pl.chmielewski.planowaniezajec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chmielewski.planowaniezajec.model.Equipment;

public interface EquipmentRepo extends JpaRepository<Equipment,Long> {
}
