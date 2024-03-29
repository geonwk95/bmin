package com.team1.model.dto.survetDto;

import com.team1.model.dto.*;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SurveyPlanInfoDto extends BaseTimeDto {
    // 출력용 DTO
    private WorkPlanDto workPlanDto;    // 작업내용
    private RecipeDto recipeDto;        // 만들제품의 레시피


}//class end
