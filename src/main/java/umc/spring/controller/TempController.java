package umc.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempQueryService;

@RestController
@RequestMapping("/temp")
@AllArgsConstructor
public class TempController {
    private final TempQueryService tempQueryService;

    @GetMapping("/exception")
    public ApiResponse temp(@RequestParam(name = "flag") Integer flag) {
        tempQueryService.CheckFlag(flag);

        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

//    @GetMapping("/exception")
//    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
//        tempQueryService.CheckFlag(flag);
//        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
//    }
}
