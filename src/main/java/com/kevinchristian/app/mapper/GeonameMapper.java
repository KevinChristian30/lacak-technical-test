package com.kevinchristian.app.mapper;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Kevin Christian
 * @since 17/01/2025
 **/
public interface GeonameMapper {
    /**
     * Converts the content of a TSV file (provided as a {@link MultipartFile}) into a list of {@link GeonameCreateDTO} objects.
     * The file is expected to contain rows of data, where each row corresponds to a {@link GeonameCreateDTO}.
     *
     * <p>This method reads the provided TSV file, parses each line, and maps the values to a list of DTOs.
     * The exact mapping logic should align with the structure of the TSV file and the fields in the DTO.</p>
     *
     * <p>This method will skip the first line of the TSV file because the file contains a header.</p>
     *
     * @param multipartFile The TSV file that contains the data to be converted into DTOs.
     *                      This file is expected to be uploaded as part of an HTTP request.
     * @return A list of {@link GeonameCreateDTO} objects populated with the parsed data from the file.
     * @throws IOException If there is an error reading the file or parsing its content.
     */
    List<GeonameCreateDTO> toCreateDTOs(MultipartFile multipartFile);
}
