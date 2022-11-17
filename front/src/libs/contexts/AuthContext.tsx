import { useRouter } from "next/router";
import { createContext, ReactNode, useState } from "react";
import { api } from "../../services/api";
import {
  AuthContextData,
  RegisterCredentials,
  SignInCredentials,
  User,
} from "../types";

type props = {
  children: ReactNode;
};

export const AuthContext = createContext({} as AuthContextData);

export function AuthProvider({ children }: props) {
  const [user, setUser] = useState<User>();
  let isAuthenticated = !!user;
  const router = useRouter();

  async function signIn({ cpf, senha }: SignInCredentials) {
    try {
      const { data } = await api.get(`/usuarios/cpf/${cpf}`);
      console.log(data);

      if (data && data.senha === senha) {
        setUser({
          ...data,
        });

        router.push("/dashboard");
      }
    } catch (err) {
      console.log(err);
    }
  }

  async function registerAccount(account: RegisterCredentials) {
    try {
      const user = await api.post("/usuarios/cadastrar", {
        ...account,
      });

      console.log(user);
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, user, signIn, registerAccount }}
    >
      {children}
    </AuthContext.Provider>
  );
}
