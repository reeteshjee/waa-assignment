import { useState } from "react";

export default function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleLogin = async () => {
        if (!username || !password) {
            setError("Please enter both username and password.");
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/authenticate/", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password }),
            });

            if (response.ok) {
                localStorage.setItem("loggedIn", "true");
                localStorage.setItem("username", username);
                window.location.href = "/";
            } else {
                setError("Invalid credentials. Please try again.");
            }
        } catch (error) {
            setError("Failed to connect to the server.");
        }
    };

    return (
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-4">
                    <div className="card mt-5">
                        <div className="card-body p-5">
                            <h3 className="text-center">Enter Your Credentials</h3>
                            <hr />
                            {error && <div className="alert alert-danger">{error}</div>}
                            <div className="form-group">
                                <label>Username</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}
                                />
                            </div>
                            <div className="mt-4 form-group">
                                <label>Password</label>
                                <input
                                    type="password"
                                    className="form-control"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                            </div>
                            <button
                                className="mt-4 btn btn-primary btn-sm w-100"
                                onClick={handleLogin}
                            >
                                Sign In
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
