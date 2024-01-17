package umc.spring.converter;

import java.util.List;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.MemberPrefer;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> MemberPrefer.builder()
                        .foodCategory(foodCategory)
                        .build()
                ).toList();

    }
}
