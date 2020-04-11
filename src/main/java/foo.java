public class foo {
    第一步：注入实例
    @Autowired
    private FooService fooService;
    第二步：添加实现
//把自己的实例注入进来，比较方便理解
    @Override

    public void invokeInsertThenRollbackBySelfService() throws RollbackException {
        fooService.insertThenRollback();
    }

    //获取当前代理，这样写避免了自己调用自己的实例
    @Override
    public void invokeInsertThenRollbackByAopContext() throws RollbackException {
        ((FooService) (AopContext.currentProxy())).insertThenRollback();
    }

    //再加一层事务
    @Transactional(rollbackFor = RollbackException.class)
    @Override
    public void invokeInsertThenRollbackAddTransactional() throws RollbackException {
        insertThenRollback();
    }

    第三步：
    添加测试方法
            可以先注释CommandLineRunner里面的内容

    @Slf4j
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class DeclarativeTransactionDemoApplicationTests {
        @Autowired
        private FooService fooService;
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Test
        public void invokeInsertThenRollback() {
            try {
                fooService.invokeInsertThenRollback();
            } catch (Exception e) {
                log.info("BBB {}",
                        jdbcTemplate
                                .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
            }
        }

        @Test
        public void invokeInsertThenRollbackBySelfService() {
            try {
                fooService.invokeInsertThenRollbackBySelfService();
            } catch (Exception e) {
                log.info("BBB {}",
                        jdbcTemplate
                                .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
            }
        }

        @Test
        public void invokeInsertThenRollbackByAopContext() {
            try {
                fooService.invokeInsertThenRollbackByAopContext();
            } catch (Exception e) {
                log.info("BBB {}",
                        jdbcTemplate
                                .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
            }
        }

        @Test
        public void invokeInsertThenRollbackAddTransactional() {
            try {
                fooService.invokeInsertThenRollbackAddTransactional();
            } catch (Exception e) {
                log.info("BBB {}",
                        jdbcTemplate
                                .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
            }
        }

    }
}
