package compeople.pages;

public class AllPages {

    //Pages
    private HomePage homepage;
    private KarrierePage karriere;
    private BewerbungsFormularPage bewerbungsFormularPage;

    public HomePage getHomepage() {
        if (homepage == null) {
            homepage = new HomePage();
        }
        return homepage;
    }

    public KarrierePage getKarriere(){
        if(karriere==null){
            karriere = new KarrierePage();
        }
        return karriere;
    }

    public BewerbungsFormularPage getBewerbungsFormularPage() {
        if (bewerbungsFormularPage == null){
            bewerbungsFormularPage = new BewerbungsFormularPage();
        }
        return bewerbungsFormularPage;
    }
}
