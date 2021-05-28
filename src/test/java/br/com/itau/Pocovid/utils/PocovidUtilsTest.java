//package br.com.itau.Pocovid.utils;
//
//import br.com.itau.Pocovid.exceptions.UtilsException;
//import br.com.itau.Pocovid.model.RequestDto;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PocovidUtilsTest {
//
//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
//
//    @Test
//    public void shouldReturnExceptionMessageWhenCountryIsNull() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setData("18-01");
//        requestDto.setEmail("email@email");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir o Pais");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnExceptionMessageWhenCountryIsEmpty() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setData("18-01");
//        requestDto.setEmail("email@email");
//        requestDto.setCountry("");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir o Pais");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnExceptionMessageWhenDataIsNull() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setCountry("brazil");
//        requestDto.setEmail("email@email");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir a Data");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnExceptionMessageWhenDataIsEmpty() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setCountry("brazil");
//        requestDto.setEmail("email@email");
//        requestDto.setData("");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir a Data");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnExceptionMessageWhenEmailIsNull() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setCountry("brazil");
//        requestDto.setData("18/01");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir o e-mail");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnExceptionMessageWhenEmailIsEmpty() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setCountry("brazil");
//        requestDto.setData("18/01");
//        requestDto.setEmail("");
//
//        exceptionRule.expect(UtilsException.class);
//        exceptionRule.expectMessage("E necessario  inserir o e-mail");
//
//        PocovidUtils.validateParameters(requestDto);
//
//    }
//
//    @Test
//    public void shouldReturnTrueWhenAllParameterAreNotNullOrEmpty() {
//        RequestDto requestDto = new RequestDto();
//        requestDto.setCountry("brazil");
//        requestDto.setData("18/01");
//        requestDto.setEmail("email@email");
//
//        boolean result = PocovidUtils.validateParameters(requestDto);
//
//        assertTrue(result);
//    }
//}