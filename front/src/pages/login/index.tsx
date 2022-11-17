import { DefaultLayout } from "../../layouts";
import Link from "next/link";
import { AuthContext } from "../../libs/contexts/AuthContext";
import { useContext, FormEvent, useState } from "react";

export default function LoginPage() {
  
  const { signIn } = useContext(AuthContext);
  const [cpf, setCPF] = useState("");
  const [senha, setSenha] = useState("");

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();

    const data = {
      cpf: cpf,
      senha: senha,
    };
    await signIn(data);
  };

  return (
    <div className="index">
      <DefaultLayout variant="nofooter">
        <div className="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow-md sm:p-6 md:p-8 dark:bg-gray-800 dark:border-gray-700">
          <form
            onSubmit={(e) => handleSubmit(e)}
            className="space-y-6"
            action="#"
          >
            <h5 className="text-xl font-medium text-gray-900 dark:text-white">
              Entre na plataforma
            </h5>
            <div>
              <label
                htmlFor="cpf"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Seu CPF
              </label>
              <input
                type="cpf"
                name="cpf"
                id="cpf"
                value={cpf}
                onChange={(e) => setCPF(e.target.value)}
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                placeholder="1324424122"
                required
              />
            </div>
            <div>
              <label
                htmlFor="password"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Sua senha
              </label>
              <input
                type="password"
                name="password"
                id="password"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
                placeholder="••••••••"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                required
              />
            </div>
            <button
              type="submit"
              className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
            >
              Entrar com sua conta
            </button>
            <div className="text-sm font-medium text-gray-500 dark:text-gray-300">
              Not registered?{" "}
              <Link
                className="text-blue-700 hover:underline dark:text-blue-500"
                href={"/register"}
              >
                Create account
              </Link>
            </div>
          </form>
        </div>
      </DefaultLayout>
    </div>
  );
}
