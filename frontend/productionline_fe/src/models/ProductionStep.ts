export type ProductionStep = {
  readonly id: number;
  name: string;
  productionTimeInMinutes: number;
  failureProbability: number;
};
