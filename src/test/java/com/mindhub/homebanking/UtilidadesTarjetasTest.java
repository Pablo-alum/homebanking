package com.mindhub.homebanking;


import Utilidades.UtilidadesTarjeta;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class UtilidadesTarjetasTest {

   @Test
   public void ELNumeroDeLaTarjetaEsCreado(){
      String tarjetaNumero = String.valueOf(UtilidadesTarjeta.getNumeroTarjeta());
      assertThat(tarjetaNumero,is(not(emptyOrNullString())));
   }
   @Test
   public  void  LACantidadDeNumerosqueTieneQUeTenerTarjeta(){
      String tarjtaNumero = UtilidadesTarjeta.getNumeroTarjeta();

      assertThat(
              tarjtaNumero.length(),is(19)
      );
   }


   @Test
   public  void LACandiaDENUmerosqueTieneQueTenerCVV(){
      String numerocvv = String.valueOf(UtilidadesTarjeta.getCvv());
      assertThat(
              numerocvv.length(),is(3)
      );
   }
}
