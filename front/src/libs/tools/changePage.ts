import Router from "next/router";

export function handleChangePage(page: string) {
    Router.push(`/${page}`);
}