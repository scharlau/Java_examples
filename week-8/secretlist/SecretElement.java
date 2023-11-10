public class SecretElement {

private int value;
private boolean isSecret;  

public SecretElement (int value, boolean isSecret) {
this.value = value;
this.isSecret = isSecret;
}

public int getValue (){
return this.value;
}

public boolean isSecret () {
    return this.isSecret;
}


}