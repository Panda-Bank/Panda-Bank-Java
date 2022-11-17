import { FormEvent, useContext, useState } from "react";
import { DashBoardLayout } from "../../layouts/DashBoardLayout";
import { AuthContext } from "../../libs/contexts/AuthContext";
import { api } from "../../services/api";

export default function DashBoard() {
  const { user } = useContext(AuthContext);
  const [cpf, setCPF] = useState("");
  const [amount, setAmount] = useState("");

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();

    await api.post(`/pix/${user?.cpf}/${cpf}`, {
      pix: `${amount}`,
    });
  };

  return (
    <div className="index">
      <DashBoardLayout nome={`${user?.nome}`}>
        <div className="flex justify-between gap-16">
          <div className="flex justify-between items-center gap-16 div pl-40 pr-8 py-8 bg-zinc-900 rounded-md bg-gradient-to-r from-zinc-900 to-zinc-600">
            <h1 className="text-2xl text-white">Transferir PIX</h1>
            <div className=" flex items-center w-max p-4 bg-white border border-gray-200 rounded-lg shadow-md sm:p-6 md:p-8 dark:bg-gray-800 dark:border-gray-700">
              <form
                onSubmit={(e) => handleSubmit(e)}
                className="space-y-4"
                action="#"
              >
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
                    htmlFor="quantidade"
                    className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                  >
                    Quantidade
                  </label>
                  <input
                    type="text"
                    name="quantidade"
                    id="quantidade"
                    value={amount}
                    onChange={(e) => setAmount(e.target.value)}
                    placeholder="321"
                    className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                    required
                  />
                </div>
                <button
                  type="submit"
                  className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                >
                  Enviar
                </button>
              </form>
            </div>
          </div>
          <div className="flex justify-between items-center gap-8 div text-2xl text-white px-40 bg-green-400 rounded-md bg-gradient-to-r from-cyan-500 to-blue-500 ">
            <h1>Saldo</h1>
            {new Intl.NumberFormat("pt-BR", {
              style: "currency",
              currency: "BRL",
            }).format(user?.saldo as number || 0)}
          </div>
        </div>
      </DashBoardLayout>
    </div>
  );
}
