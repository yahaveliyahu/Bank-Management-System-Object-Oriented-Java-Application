package project;

public class Client {
    private String clientName;
    private int clientRank;

    public Client(String clientName, int clientRank) {
        this.clientName = clientName;
        this.clientRank = clientRank;
    }


    public int getClientRank() {
        return clientRank;
    }

    public void setClientRank(int clientRank) {
        this.clientRank = clientRank;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return clientRank == client.clientRank && clientName.equals(client.clientName);
    }
}

