public enum OrderStateMachine {

    /**
     * 调度中
     */
    DISPATCHING {
        public OrderStateMachine nextState() {
            return DELIVERING;
        }

        public OrderStateMachine prevState() {
            return this;
        }
    },

    DELIVERING {
        public OrderStateMachine nextState() {
            return RECEIVED;
        }

        public OrderStateMachine prevState() {
            return DISPATCHING;
        }
    },

    RECEIVED {
        public OrderStateMachine nextState() {
            return RECEIVED;
        }

        public OrderStateMachine prevState() {
            return DELIVERING;
        }
    };

    public abstract OrderStateMachine nextState();


    public abstract OrderStateMachine prevState();


}
