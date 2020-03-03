package sample;

public class Settings {

    private int neljanneksenPituus; // Seconds
    private int neljannesMaara;
    private int jatkoeraPituus; // Seconds
    private int lyhytTauko; // Seconds
    private int pitkaTauko; // Seconds
    private int aikalisa; // Seconds
    private int aikalisaLkm;
    private int hyokkausAika1; // Seconds
    private int hyokkausAika2; // Seconds
    private int virheetLkm;
    private int pelikellonSummeri; // Seconds
    private int heittokellonSummeri; // Seconds
    private boolean kellonSuunta; // true = down | false = up
    private int waitingBeforeStart; // seconds

    public Settings() {}

    public Settings(int neljanneksenPituus, int neljannesMaara, int jatkoeraPituus, int lyhytTauko,
                    int pitkaTauko, int aikalisa, int aikalisaLkm, int hyokkausAika1, int hyokkausAika2,
                    int virheetLkm, int pelikellonSummeri, int heittokellonSummeri, boolean kellonSuunta,
                    int waitingBeforeStart) {
        this.neljanneksenPituus = neljanneksenPituus;
        this.neljannesMaara = neljannesMaara;
        this.jatkoeraPituus = jatkoeraPituus;
        this.lyhytTauko = lyhytTauko;
        this.pitkaTauko = pitkaTauko;
        this.aikalisa = aikalisa;
        this.aikalisaLkm = aikalisaLkm;
        this.hyokkausAika1 = hyokkausAika1;
        this.hyokkausAika2 = hyokkausAika2;
        this.virheetLkm = virheetLkm;
        this.pelikellonSummeri = pelikellonSummeri;
        this.heittokellonSummeri = heittokellonSummeri;
        this.kellonSuunta = kellonSuunta;
        this.waitingBeforeStart = waitingBeforeStart;
    }

    public int getNeljanneksenPituus() {
        return neljanneksenPituus;
    }

    public void setNeljanneksenPituus(int neljanneksenPituus) {
        this.neljanneksenPituus = neljanneksenPituus;
    }

    public int getNeljannesMaara() {
        return neljannesMaara;
    }

    public void setNeljannesMaara(int neljannesMaara) {
        this.neljannesMaara = neljannesMaara;
    }

    public int getJatkoeraPituus() {
        return jatkoeraPituus;
    }

    public void setJatkoeraPituus(int jatkoeraPituus) {
        this.jatkoeraPituus = jatkoeraPituus;
    }

    public int getLyhytTauko() {
        return lyhytTauko;
    }

    public void setLyhytTauko(int lyhytTauko) {
        this.lyhytTauko = lyhytTauko;
    }

    public int getPitkaTauko() {
        return pitkaTauko;
    }

    public void setPitkaTauko(int pitkaTauko) {
        this.pitkaTauko = pitkaTauko;
    }

    public int getAikalisa() {
        return aikalisa;
    }

    public void setAikalisa(int aikalisa) {
        this.aikalisa = aikalisa;
    }

    public int getAikalisaLkm() {
        return aikalisaLkm;
    }

    public void setAikalisaLkm(int aikalisaLkm) {
        this.aikalisaLkm = aikalisaLkm;
    }

    public int getHyokkausAika1() {
        return hyokkausAika1;
    }

    public void setHyokkausAika1(int hyokkausAika1) {
        this.hyokkausAika1 = hyokkausAika1;
    }

    public int getHyokkausAika2() {
        return hyokkausAika2;
    }

    public void setHyokkausAika2(int hyokkausAika2) {
        this.hyokkausAika2 = hyokkausAika2;
    }

    public int getVirheetLkm() {
        return virheetLkm;
    }

    public void setVirheetLkm(int virheetLkm) {
        this.virheetLkm = virheetLkm;
    }

    public int getPelikellonSummeri() {
        return pelikellonSummeri;
    }

    public void setPelikellonSummeri(int pelikellonSummeri) {
        this.pelikellonSummeri = pelikellonSummeri;
    }

    public int getHeittokellonSummeri() {
        return heittokellonSummeri;
    }

    public void setHeittokellonSummeri(int heittokellonSummeri) {
        this.heittokellonSummeri = heittokellonSummeri;
    }

    public boolean getKellonSuunta() {
        return kellonSuunta;
    }

    public void setKellonSuunta(boolean kellonSuunta) {
        this.kellonSuunta = kellonSuunta;
    }

    public void setWaitingBeforeStart(int waitingBeforeStart) { this.waitingBeforeStart = waitingBeforeStart;}

    public int getWaitingBeforeStart() {return this.waitingBeforeStart;}
}
