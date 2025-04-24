package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.ReviewDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateHouseDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateReviewDTO;
import Application.RentalHouse.model.Review;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    //entity to dto
    @Mapping(source = "house.house_id",target = "houseId")
    @Mapping(source = "user.id",target="userId")
    @Mapping(source = "created_at", target = "created_at")
    ReviewDTO toDTO(Review review);

    //dto to entity
    @Mapping(target = "house",ignore = true)
    @Mapping(target = "user",ignore = true)
    Review entity(ReviewDTO reviewDTO);

    //update review
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReviewFromDTO(UpdateReviewDTO updateReviewDTO, @MappingTarget Review review);
}
