public class Walec {
    private double promienPodstawy;
    private double wysokosc;
    public Walec(double promienPodstawy, double wysokosc){
        this.promienPodstawy = promienPodstawy;
        this.wysokosc = wysokosc;
    }

    public Walec (){

    }
    public void setPromienPodstawy (double promienPodstawy ){
        this.promienPodstawy = promienPodstawy;
    }

    public  void setWysokosc(double wysokosc){
        this.wysokosc = wysokosc;
    }

    public double getPromienPodstawy (){
        return this.promienPodstawy;
    }

    public double getWysokosc () {
        return this.wysokosc;
    }

    public double polePowierzchniPodstawy(){
        return Math.PI*Math.pow(promienPodstawy, 2);
    }

    public double polePowierzchniBocznej(){
        return 2*Math.PI*promienPodstawy*wysokosc;
    }

    public double polePowierzchniCalkowitej(){
        return 2*this.polePowierzchniPodstawy()+this.polePowierzchniBocznej();
    }

    public double objetosc(){
        return this.polePowierzchniPodstawy()*wysokosc;
    }





}
