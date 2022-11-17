import { handleChangePage } from "../../../libs/tools";
import { EButton } from "../../Button";
import styles from "./styles.module.scss";

type props = {
  variant?: string;
  nome?: string;
};

export function DashBoardNavbar({ variant, nome }: props) {
  return variant != "settings" ? (
    <header className={styles.header}>
      <nav className={styles["header_nav"]}>
        <EButton onClick={() => handleChangePage("/dashboard/config")} variant="outline">
          configurações
        </EButton>
      </nav>
      <div className={styles["header_name"]}>
        <p>
          <span>Bem vindo(a)</span>, {nome}
        </p>
      </div>
    </header>
  ) : (
    <header className={styles.header}>
      <nav className={styles["header_nav"]}>
        <EButton onClick={() => handleChangePage("dashboard")}>
          Dashboard
        </EButton>
      </nav>
      <div className={styles["header_name"]}>
        <p>
          <span>Configurações de </span>, { nome }
        </p>
      </div>
    </header>
  );
}
