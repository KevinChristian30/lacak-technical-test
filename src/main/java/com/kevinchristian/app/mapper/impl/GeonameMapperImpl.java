package com.kevinchristian.app.mapper.impl;

import com.kevinchristian.app.constant.GeonameTSVIndex;
import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.domain.entity.Geoname;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.util.NumberUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

@Component
public class GeonameMapperImpl implements GeonameMapper {
    private GeonameCreateDTO fromTabDelimitedString(String source) {
        final String DELIMITER = "\t";
        String[] values = source.split(DELIMITER, -1);

        GeonameCreateDTO geonameCreateDTO = new GeonameCreateDTO();
        geonameCreateDTO.setId(NumberUtil.parseLongOrNull(values[GeonameTSVIndex.ID_INDEX]));
        geonameCreateDTO.setName(values[GeonameTSVIndex.NAME_INDEX]);
        geonameCreateDTO.setAscii(values[GeonameTSVIndex.ASCII_INDEX]);
        geonameCreateDTO.setAltName(values[GeonameTSVIndex.ALT_NAME_INDEX]);
        geonameCreateDTO.setLat(NumberUtil.parseDoubleOrNull(values[GeonameTSVIndex.LAT_INDEX]));
        geonameCreateDTO.setLongitude(NumberUtil.parseDoubleOrNull(values[GeonameTSVIndex.LONG_INDEX]));
        geonameCreateDTO.setFeatClass(values[GeonameTSVIndex.FEAT_CLASS_INDEX]);
        geonameCreateDTO.setFeatCode(values[GeonameTSVIndex.FEAT_CODE_INDEX]);
        geonameCreateDTO.setCountry(values[GeonameTSVIndex.COUNTRY_INDEX]);
        geonameCreateDTO.setCc2(values[GeonameTSVIndex.CC2_INDEX]);
        geonameCreateDTO.setAdmin1(values[GeonameTSVIndex.ADMIN1_INDEX]);
        geonameCreateDTO.setAdmin2(values[GeonameTSVIndex.ADMIN2_INDEX]);
        geonameCreateDTO.setAdmin3(values[GeonameTSVIndex.ADMIN3_INDEX]);
        geonameCreateDTO.setAdmin4(values[GeonameTSVIndex.ADMIN4_INDEX]);
        geonameCreateDTO.setPopulation(NumberUtil.parseLongOrNull(values[GeonameTSVIndex.POPULATION_INDEX]));
        geonameCreateDTO.setElevation(NumberUtil.parseLongOrNull(values[GeonameTSVIndex.ELEVATION_INDEX]));
        geonameCreateDTO.setDem(NumberUtil.parseLongOrNull(values[GeonameTSVIndex.DEM_INDEX]));
        geonameCreateDTO.setTz(values[GeonameTSVIndex.TZ_INDEX]);
        geonameCreateDTO.setModifiedAt(values[GeonameTSVIndex.MODIFIED_AT_INDEX]);

        return geonameCreateDTO;
    }

    @Override
    public List<GeonameCreateDTO> toCreateDTOs(MultipartFile multipartFile) {
        List<GeonameCreateDTO> geonameCreateDTOS = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                geonameCreateDTOS.add(fromTabDelimitedString(line));
            }
        } catch (IOException e) {
        }

        return geonameCreateDTOS;
    }

    @Override
    public Geoname toEntity(GeonameCreateDTO dto) {
        return Geoname.builder()
                .geonameId(dto.getId())
                .name(dto.getName())
                .ascii(dto.getAscii())
                .altName(dto.getAltName())
                .latitude(dto.getLat())
                .longitude(dto.getLongitude())
                .featCode(dto.getFeatCode())
                .country(dto.getCountry())
                .cc2(dto.getCc2())
                .admin1(dto.getAdmin1())
                .admin2(dto.getAdmin2())
                .admin3(dto.getAdmin3())
                .admin4(dto.getAdmin4())
                .population(dto.getPopulation())
                .elevation(dto.getElevation())
                .dem(dto.getDem())
                .tz(dto.getTz())
                .build();
    }

    @Override
    public List<Geoname> toEntities(List<GeonameCreateDTO> geonameCreateDTOS) {
        return geonameCreateDTOS.stream().map(this::toEntity).toList();
    }
}
