package com.company.osproject.repository;

import com.company.osproject.controller.ImageController;
import com.company.osproject.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Optional<Image> findByImageIdAndDeletedAtIsNull(Integer imageId);

    Optional<Image> findByImageNameAndDeletedAtIsNull(String imageName);
}
