package com.banana.blog.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.banana.blog.domain.PostStatus;
import com.banana.blog.domain.dtos.CategoryDto;
import com.banana.blog.domain.entities.Category;
import com.banana.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE) // we can ignore unmapped target because we are not mapping all the fields of the category entity to the category dto
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount") // we can use this to calculate the post count from the posts list in the category entity and set it to the postCount field in the category dto
    CategoryDto toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if(null == posts) {
            return 0;
        }
        return posts.stream()
        .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
        .count();
    }
}
