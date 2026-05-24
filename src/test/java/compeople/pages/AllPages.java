package compeople.pages;

public class AllPages {

    private Homepage homepage;
    private Services services;
    private Karriere karriere;

    public Homepage getHomepage() {
        if (homepage == null) {
            homepage = new Homepage();
        }
        return homepage;
    }

    public Services getServices() {
        if (services == null){
            services = new Services();
        }
        return services;
    }

    public Karriere getKarriere(){
        if(karriere==null){
            karriere = new Karriere();
        }
        return karriere;
    }
}
