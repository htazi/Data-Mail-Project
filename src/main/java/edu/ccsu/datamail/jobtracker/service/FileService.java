package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.file.JobFileNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.file.ProductionFile;
import edu.ccsu.datamail.jobtracker.repository.ProductionFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileService
{
    private final ProductionFileRepository productionFileRepository;

    @Autowired
    public FileService(ProductionFileRepository productionFileRepository)
    {
        this.productionFileRepository = productionFileRepository;
    }

    /**
     * Attempts to find a file in the database with the specified Id
     *
     * @param productionFileId the id of the file in the database
     * @return a new ProductionFile object from the database
     * @throws JobFileNotFoundException if the file isn't in the database
     */
    public ProductionFile getProductionFile(Integer productionFileId) throws JobFileNotFoundException
    {
        Optional<ProductionFile> productionFileContainer = productionFileRepository.findById(productionFileId);
        return productionFileContainer.orElseThrow(() -> new JobFileNotFoundException("File with Id "
                + productionFileId + " not found"));
    }
}
