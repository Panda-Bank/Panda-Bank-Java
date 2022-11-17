import { useRouter } from "next/router";
import { useContext } from "react";
import { EButton } from "../../../components/Button";
import { DashBoardLayout } from "../../../layouts";
import { AuthContext } from "../../../libs/contexts/AuthContext";
import { api } from "../../../services/api";

export default function Config() {
  const { user } = useContext(AuthContext);
  const router = useRouter();

  async function handleDeleteAccount() {
    await api.delete(`/usuarios/delete/${user?.id}`);
    router.push("/login");
  }

  async function handleChangeKey() {
    // usar nanoid
  }

  return (
    <div className="index">
      <DashBoardLayout variant="settings" nome={user?.nome}>
        <div className="bg-gray-800 p-16 rounded-md">
          <EButton>Delete Account</EButton>
          <form action="">
            <div className="items-center gap-16 div pl-8 pr-8 py-8 bg-zinc-900 rounded-md bg-gradient-to-r from-zinc-900 to-zinc-600 mb-8 mt-16">
              <input
                id="link-checkbox"
                type="checkbox"
                value=""
                className="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
              />
              <label
                htmlFor="link-checkbox"
                className="ml-2 text-sm font-medium text-white"
              >
                Chave aleatória.
              </label>
            </div>

            <EButton>Nova Chave</EButton>
          </form>
        </div>
      </DashBoardLayout>
    </div>
  );
}
