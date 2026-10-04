import { useState } from "react";
import api from "./api";

export default function App() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [result, setResult] = useState(null);

  const show = (status, data) => setResult({ status, data });

  const handle = async (request) => {
    try {
      const res = await request();
      show(res.status, res.data);
    } catch (error) {
      if (error.response) {
        show(error.response.status, error.response.data);
      } else {
        show("NO RESPONSE", error.message);
      }
    }
  };

  const signIn = () =>
    handle(() => api.post("/users/signin", { email, password }));

  const getProjects = () => handle(() => api.get("/projects"));

  return (
    <div style={{ padding: 20, fontFamily: "sans-serif" }}>
      <h3>Session Auth Test</h3>

      <div style={{ marginBottom: 8 }}>
        <input
          type="text"
          placeholder="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>
      <div style={{ marginBottom: 8 }}>
        <input
          type="password"
          placeholder="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      <button onClick={signIn}>Sign in</button>{" "}
      <button onClick={getProjects}>Get my projects</button>

      <pre style={{ marginTop: 16, background: "#eee", padding: 12 }}>
        {result
          ? `Status: ${result.status}\n\n${JSON.stringify(result.data, null, 2)}`
          : "No request yet"}
      </pre>
    </div>
  );
}