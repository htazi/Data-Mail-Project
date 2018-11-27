package edu.ccsu.datamail.jobtracker.repository;

import edu.ccsu.datamail.jobtracker.entity.file.ProductionFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionFileRepository extends CrudRepository<ProductionFile, Integer>
{
    List<ProductionFile> getAll();
}
