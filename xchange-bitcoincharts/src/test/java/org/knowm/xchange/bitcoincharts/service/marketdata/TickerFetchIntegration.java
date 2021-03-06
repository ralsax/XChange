package org.knowm.xchange.bitcoincharts.service.marketdata;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitcoincharts.BitcoinChartsExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.polling.marketdata.PollingMarketDataService;

/**
 * @author timmolter
 */
public class TickerFetchIntegration {

  @Test
  public void tickerFetchTest() throws Exception {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(BitcoinChartsExchange.class.getName());
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);
    exchange.remoteInit();
    PollingMarketDataService marketDataService = exchange.getPollingMarketDataService();
    Ticker ticker = marketDataService.getTicker(new CurrencyPair("BTC", "bitstampUSD"));
    System.out.println(ticker.toString());
    assertThat(ticker).isNotNull();
  }

}
