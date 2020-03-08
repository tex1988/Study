package com.home.InnerClassTask;

import java.math.BigDecimal;

public class InnerClassInheritanceTask1 {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public class Apt3Bedroom extends Building.Apartments {
        Apt3Bedroom (Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall {
        BigHall (Building building, BigDecimal square) {
            building.super(square);
        }
    }
}
