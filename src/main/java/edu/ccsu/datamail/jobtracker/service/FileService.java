package edu.ccsu.datamail.jobtracker.service;

import edu.ccsu.datamail.jobtracker.entity.file.JobFileNotFoundException;
import edu.ccsu.datamail.jobtracker.entity.file.ProductionFile;
import edu.ccsu.datamail.jobtracker.repository.ProductionFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * Returns all ProductionFiles stored in the database
     *
     * @return a list of all the productionfiles
     */
    public List<ProductionFile> getAllFiles()
    {
        return productionFileRepository.getAll();
    }

    /**
     * Saves a ProductionFile object to the database
     *
     * @param productionFile a productionfile that will be saved to the database
     */
    public void saveFile(ProductionFile productionFile)
    {
        productionFileRepository.save(productionFile);
    }
}
