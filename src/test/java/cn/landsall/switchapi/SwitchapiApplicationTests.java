package cn.landsall.switchapi;

import cn.landsall.switchapi.entity.model.GameDetail;
import cn.landsall.switchapi.entity.GameInfo;
import cn.landsall.switchapi.entity.GamePrice;
import cn.landsall.switchapi.entity.model.GameShop;
import cn.landsall.switchapi.entity.model.Order;
import cn.landsall.switchapi.entity.model.PriceDetail;
import cn.landsall.switchapi.service.impl.GameInfoServiceImpl;
import cn.landsall.switchapi.service.impl.GamePriceServiceImpl;
import cn.landsall.switchapi.service.impl.OrderInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SwitchapiApplicationTests {
    @Autowired
    private GameInfoServiceImpl gameInfoService;
    @Autowired
    private GamePriceServiceImpl priceService;
     @Autowired
     private OrderInfoServiceImpl orderInfoService;


    @Test
    void contextLoads() {
        /*InsertGame();*/
        List<Order> orderList = orderInfoService.selectOrderList(1L, 1, 1);
        orderList.forEach(System.out::println);

        List<PriceDetail> priceDetails = gameInfoService.listPriceDetailById(5L);
        priceDetails.forEach(System.out::println);

    /*    GameDetail gameDetail = gameInfoService.getOneGameDetail(5L);
        System.out.println(gameDetail);

        List<GameShop> gameShopList = gameInfoService.listGameShop();
        gameShopList.forEach(System.out::println);*/

      /*  InsertPrice(5,295,LocalDate.of(2021,6,15));
        InsertPrice(5,300,LocalDate.of(2021,6,5));
        InsertPrice(5,305,LocalDate.of(2021,6,1));
        InsertPrice(5,300,LocalDate.of(2021,5,27));
        InsertPrice(5,299,LocalDate.of(2021,5,26));
        InsertPrice(5,300,LocalDate.of(2021,5,25));
*/
    }

    private void InsertGame(){
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameName("NS 马里奥奥德赛");
        gameInfo.setType("switch");
        gameInfo.setGamePrice(BigDecimal.valueOf(285));
        gameInfo.setSellCount(6041);
        gameInfo.setUrlCover("url");
        gameInfo.setGameDetail("《超级马力欧 奥德赛》（日语：スーパーマリオ オデッセイ，英语：Super Mario Odyssey）是一款由任天堂企划制作本部开发并由任天堂发行（中国大陆由腾讯游戏发行）在任天堂Switch平台上的平台游戏。");
        gameInfoService.save(gameInfo);
    }

    private void InsertPrice(int gameId, BigDecimal price, LocalDate localDate){
        GamePrice gamePrice = new GamePrice();
        gamePrice.setGameId(gameId);
        gamePrice.setDatePrice(price);
        gamePrice.setDate(localDate);
        priceService.save(gamePrice);
    }

}
