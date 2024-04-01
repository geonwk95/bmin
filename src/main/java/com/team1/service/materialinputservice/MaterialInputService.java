package com.team1.service.materialinputservice;

import com.team1.model.dto.MaterialInputDto;
import com.team1.model.dto.SurveyBDto;
import com.team1.model.dto.SurveyDto;
import com.team1.model.entity.MaterialInputEntity;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.ProductEntity;
import com.team1.model.entity.SurveyEntity;
import com.team1.model.repository.MaterialInputRepository;
import com.team1.model.repository.ProductRepository;
import com.team1.model.repository.SurveyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialInputService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    MaterialInputRepository materialInputRepository;
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public boolean doInputPost(int sno){
        System.out.println("MaterialInputService.doInputPost");
        System.out.println("sno = " + sno);


        Optional<SurveyEntity> optionalSurveyEntity = surveyRepository.findById( sno );

        if (!optionalSurveyEntity.isPresent()) return false;

        SurveyEntity surveyEntity = optionalSurveyEntity.get();
        System.out.println("surveyEntity = " + surveyEntity);
        System.out.println("optionalSurveyEntity = " + optionalSurveyEntity);
        ProductEntity optionalProductEntity = productRepository.findBySnoSQL( sno );
            // insert
        MaterialInputEntity saveMaterialInput
                = materialInputRepository.save( MaterialInputEntity.builder().build() );
        if(saveMaterialInput.getMipno() >= 1){
            saveMaterialInput.setSurveyEntity( surveyEntity );
            saveMaterialInput.setProductEntity( optionalProductEntity );
        // 인풋넘버 넣는곳
            return true;
        }
        return false;
    }

    @Transactional
    public List<MaterialInputDto> doInputInfoGet(){
        System.out.println("MaterialInputController.doInputInfoGet");
        List<MaterialInputEntity> result = materialInputRepository.findAll();
        System.out.println("result = " + result);
        // Entity를 Dto로 변환한다
        List<MaterialInputDto> materialInputDtoList = new ArrayList<>();
            // 1. 꺼내온 entity를 순회한다
        for (int i = 0; i < result.size(); i++) {
            // 2.하나씩 entity를 꺼낸다
            MaterialInputEntity materialInputEntity = result.get(i);
            // 3. 해당 entity를 dto로 변환한다
            MaterialInputDto materialInputDto = materialInputEntity.toDto();
            // 4. 변환된 dto를 리스트에 담는다
            materialInputDtoList.add(materialInputDto);

        }
        return materialInputDtoList;
    }

}
