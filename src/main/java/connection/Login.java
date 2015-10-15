package connection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Login {
    private final String id, device, token;

    @JsonCreator
    public Login(
            @JsonProperty("id") final String id,
            @JsonProperty("device") final String device,
            @JsonProperty("token") final String token) {
        this.id = id;
        this.device = device;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getDevice() {
        return device;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", device='" + device + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Login login = (Login) o;

        if (!id.equals(login.id)) return false;
        if (!device.equals(login.device)) return false;
        return token.equals(login.token);

    }
}
