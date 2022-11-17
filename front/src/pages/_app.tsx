import "../styles/globals.scss";
import "../styles/button.scss";
import "../styles/home.scss";
import "../styles/Default.layout.scss";
import "../styles/footer.scss";
import "../styles/card.scss";
import type { AppProps } from "next/app";
import { AuthProvider } from "../libs/contexts/AuthContext";

export default function App({ Component, pageProps }: AppProps) {
  return (
    <AuthProvider>
      <Component {...pageProps} />
    </AuthProvider>
  );
}
