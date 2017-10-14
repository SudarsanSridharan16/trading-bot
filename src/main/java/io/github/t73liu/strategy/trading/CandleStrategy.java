package io.github.t73liu.strategy.trading;

import eu.verdelhan.ta4j.*;
import eu.verdelhan.ta4j.indicators.candles.*;
import eu.verdelhan.ta4j.trading.rules.BooleanIndicatorRule;

public class CandleStrategy {
    public static Strategy getStrategy(TimeSeries series) {
        Rule entryRule = new BooleanIndicatorRule(new BullishEngulfingIndicator(series))
                .or(new BooleanIndicatorRule(new BullishHaramiIndicator(series)))
                .or(new BooleanIndicatorRule(new ThreeWhiteSoldiersIndicator(series, 3, Decimal.valueOf(1.5))));
        Rule exitRule = new BooleanIndicatorRule(new BearishEngulfingIndicator(series))
                .or(new BooleanIndicatorRule(new BearishHaramiIndicator(series)))
                .or(new BooleanIndicatorRule(new ThreeBlackCrowsIndicator(series, 3, Decimal.valueOf(1.5))));
        return new BaseStrategy(entryRule, exitRule);
    }
}
