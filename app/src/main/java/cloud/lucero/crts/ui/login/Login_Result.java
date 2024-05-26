package cloud.lucero.crts.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result: success (user details) or error message.
 */
class Login_Result {
    @Nullable
    private final LoggedInUserView success;
    @Nullable
    private final Integer error;

    /**
     * Constructor for error result.
     *
     * @param error Error code.
     */
    Login_Result(@Nullable Integer error) {
        this.error = error;
        this.success = null;
    }

    /**
     * Constructor for success result.
     *
     * @param success User details on successful login.
     */
    Login_Result(@Nullable LoggedInUserView success) {
        this.success = success;
        this.error = null;
    }

    /**
     * Get the success result.
     *
     * @return User details on success or null if there was an error.
     */
    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    /**
     * Get the error result.
     *
     * @return Error code on failure or null if the login was successful.
     */
    @Nullable
    Integer getError() {
        return error;
    }
}
