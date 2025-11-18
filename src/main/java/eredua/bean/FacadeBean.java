package eredua.bean;




public class FacadeBean {

    private static BLFacade facadeInterface;

    static {
        try {
            // Si en tu proyecto ya existe com.example.bl.BLFacadeImplementation, se instanciará.
            Class<?> impl = Class.forName("com.example.bl.BLFacadeImplementation");
            facadeInterface = (BLFacade) impl.getDeclaredConstructor().newInstance();
        } catch (Throwable t) {
            System.out.println("FacadeBean: BLFacadeImplementation no encontrada; usando MockBLFacade. (" + t.getMessage() + ")");
            facadeInterface = new MockBLFacade();
        }
    }

    public static BLFacade getBusinessLogic() {
        return facadeInterface;
    }
}
